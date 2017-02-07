package com.rr.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by Limaoran on 2016/12/30.
 */
public class AclEdit {

    /**
     * parse string as list of ACE permissions separated by
     * 分析字符串作为隔开的 ACE 权限列表中
     * @param permsString
     * @return
     */
    static Set<AclEntryPermission> parsePermissions(String permsString){
        Set<AclEntryPermission> perms = new HashSet<>();
        String [] result = permsString.split("/");
        for(String s : result){
            if(s.equals("")){
                continue;
            }
            try {
                perms.add(AclEntryPermission.valueOf(s.toUpperCase()));
            }catch (IllegalArgumentException e){
                System.err.format("Invalid permission '%s'\n",s);
                System.exit(-1);
            }
        }
        return perms;
    }

    /**
     * parse string as list of ACE flags separated by
     * 将字符串分析为 ACE 标志由分隔的列表
     * @param flagsString
     * @return
     */
    static Set<AclEntryFlag> parseFlags(String flagsString) {
        Set<AclEntryFlag> flags = new HashSet<>();
        String [] result = flagsString.split("/");
        for(String s : result){
            if(s.equals("")){
                continue;
            }
            try{
                flags.add(AclEntryFlag.valueOf(s.toUpperCase()));
            }catch (IllegalArgumentException ex){
                System.err.format("Invalid flag '%s'\n",s);
                System.exit(-1);
            }
        }
        return flags;
    }

    /**
     * parse ACE type
     * @param typeString
     * @return
     */
    static AclEntryType parseType(String typeString){
        // FIXME: support audit and alarm types in the future
        if(typeString.equalsIgnoreCase("allow"))
            return AclEntryType.ALLOW;
        if(typeString.equalsIgnoreCase("deny"))
            return AclEntryType.DENY;
        System.err.format("Invalid type '%s'\n",typeString);
        System.exit(-1);
        return null;
    }

    /**
     * Parse string of the form:
     * [user|group:]<username|groupname>:<perms>[:flags]:<allow|deny>
     * @param s
     * @param lookupService
     * @return
     */
    static AclEntry parseAceString(String s, UserPrincipalLookupService lookupService){
        String []result = s.split(":");
        // must have at least 3 components (username:perms:type)
        if(result.length<3){
            usage();
        }
        int index = 0;
        int remaining = result.length;
        // 可选的第一个组件可以表示用户或组类型
        // optional first component can indicate user or group type
        boolean isGroup = false;
        if(result[index].equalsIgnoreCase("user") || result[index].equalsIgnoreCase("group")){
            if(--remaining<3){
                usage();
            }
            isGroup = result[index++].equalsIgnoreCase("group");
        }
        // 用户和所需的权限
        // user and permissions required
        String userString = result[index++];
        remaining --;
        String permsString = result[index++];
        remaining -- ;

        // 标志是可选的
        // flags are optional
        String flagsString = "";
        String typeString = null;
        if(remaining ==1 ){
            typeString = result[index++];
        }else {
            if (remaining==2){
                flagsString = result[index++]; // 这里index为什么还++？
                typeString = result[index++];
            }else{
                usage();
            }
        }

        // lookup UserPrincipal
        UserPrincipal user = null;
        try{
            user = isGroup? lookupService.lookupPrincipalByGroupName(userString):
                    lookupService.lookupPrincipalByName(userString);
        }catch (UserPrincipalNotFoundException e){
            System.err.format("Invalid %s '%s'\n",
                    ((isGroup) ? "group" : "user"),
                    userString);
            System.exit(-1);
        }catch (IOException e){
            System.err.format("Lookup of '%s' failed: %s\n",
                    userString,e);
            System.exit(-1);
        }

        // 映射权限、 标志和类型的字符串表示的形式
        // map string representation of permissions, flags, and type
        Set<AclEntryPermission> perms = parsePermissions(permsString);
        Set<AclEntryFlag> flags = parseFlags(flagsString);
        AclEntryType type = parseType(typeString);

        // 生成的 ACL 条目
        // build the ACL entry
        return AclEntry.newBuilder()
                .setType(type)
                .setPrincipal(user)
                .setPermissions(perms)
                .setFlags(flags)
                .build();
    }

    static void usage(){
        System.err.println("usage: java AclEdit [ACL-operation] file");
        System.err.println("");
        System.err.println("Example 1: Prepends access control entry to the begining of the myfile's ACL");
        System.err.println("       java AclEdit A+alice:read_data/read_attributes:allow myfile");
        System.err.println("");
        System.err.println("Example 2: Remove the entry at index 6 of myfile's ACL");
        System.err.println("       java AclEdit A6- myfile");
        System.err.println("");
        System.err.println("Example 3: Replace the entry at index 2 of myfile's ACL");
        System.err.println("       java AclEdit A2=bob:write_data/append_data:deny myfile");
        System.exit(-1);
    }

    static enum Action{
        PRINT,
        ADD,
        REMOVE,
        REPLACE;
    }

    /**
     * Main class: parses arguments and prints or edits ACL
     * 主类︰ 解析参数和打印或编辑 ACL
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Action action = null;
        int index = -1;
        String entryString = null;

        // parse arguments
        if(args.length <1 || args[0].equals("-help") || args[0].equals("-?")){
            usage();
        }

        if(args.length==1){
            action = Action.PRINT;
        }else{
            String s = args[0];

            // A[index]+entry
            if(Pattern.matches("^A[0-9]*\\+.*",s)){
                String [] result = s.split("\\+",2);
                if(result.length==2){
                    if(result.length<2){
                        index = 0;
                    }else {
                        index = Integer.parseInt(result[0].substring(1));
                    }
                    entryString = result[1];
                    action = Action.ADD;
                }
            }

            // Aindex-
            if(Pattern.matches("^A[0-9]+\\-",s)){
                String[] result = s.split("\\-", 2);
                if (result.length == 2) {
                    index = Integer.parseInt(result[0].substring(1));
                    entryString = result[1];
                    action = Action.REMOVE;
                }
            }

            // Aindex=entry
            if(Pattern.matches("^A[0-9]+=.*",s)){
                String[] result = s.split("=", 2);
                if (result.length == 2) {
                    index = Integer.parseInt(result[0].substring(1));
                    entryString = result[1];
                    action = Action.REPLACE;
                }
            }

            if(action==null){
                usage();
            }

            int fileArg = (action==Action.PRINT)?0:1;
            Path file = Paths.get(args[fileArg]);

            // read file's ACL
            AclFileAttributeView view = Files.getFileAttributeView(file,AclFileAttributeView.class);
            if(view==null){
                System.err.println("ACLs not supported on this platform");
                System.exit(-1);
            }

            List<AclEntry> acl = view.getAcl();

            switch(action){
                // print ACL
                case PRINT:{
                    for(int i=0;i<acl.size();i++){
                        System.out.format("%5d: %s\n",i,acl.get(i));
                    }
                    break;
                }
                // add ACE to existing ACL
                case ADD:{
                    AclEntry entry = parseAceString(entryString,file.getFileSystem().getUserPrincipalLookupService());
                    if(index>acl.size()){
                        acl.add(entry);
                    }else {
                        acl.add(index,entry);
                    }
                    view.setAcl(acl);
                    break;
                }
                // remove ACE
                case REMOVE:{
                    if (index >= acl.size()) {
                        System.err.format("Index '%d' is invalid", index);
                        System.exit(-1);
                    }
                    acl.remove(index);
                    view.setAcl(acl);
                    break;
                }
                // replace ACE
                case REPLACE:{
                    if (index >= acl.size()) {
                        System.err.format("Index '%d' is invalid", index);
                        System.exit(-1);
                    }
                    AclEntry entry = parseAceString(entryString,file.getFileSystem().getUserPrincipalLookupService());
                    acl.set(index,entry);
                    view.setAcl(acl);
                    break;
                }
            }
        }
    }

}

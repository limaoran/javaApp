package com.rr.designmodel.flyweight;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Test11 {
    public static void main(String[] args) {
/*
        MyCharacter myChar1 = new MyCharacter('a');
		MyCharacter myChar2 = new MyCharacter('b');
		MyCharacter myChar3 = new MyCharacter('a');
		MyCharacter myChar4 = new MyCharacter('d');

		myChar1.display();
		myChar2.display();
		myChar3.display();
		myChar4.display();

        if(myChar1 == myChar3) {    // false
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		*/

        // 1.创建MyCharacter工厂
        MyCharacterFactory factory = new MyCharacterFactory();
        // 2.从工厂中取出相应的MyCharacter
        MyCharacter myChar1 = factory.getMyCharacter('a');
        MyCharacter myChar2 = factory.getMyCharacter('b');
        MyCharacter myChar3 = factory.getMyCharacter('a');
        MyCharacter myChar4 = factory.getMyCharacter('d');

        myChar1.display();
        myChar2.display();
        myChar3.display();
        myChar4.display();

        if(myChar1 == myChar3) {    // true
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

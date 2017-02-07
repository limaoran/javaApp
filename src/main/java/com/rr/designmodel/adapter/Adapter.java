package com.rr.designmodel.adapter;

/**
 * Created by Limaoran on 2016/11/17.
 */
class Current {
    public void use220V() {
        System.out.println("使用220V电流");
    }
}

public class Adapter extends Current{
    public void use18V() {
        System.out.println("使用适配器");
        this.use220V();
    }

    public static void main(String[] args) {

        Current current = new Current();
		current.use220V();

		Adapter adapter = new Adapter();
		adapter.use18V();

        Adapter2 adapter2 = new Adapter2(new Current());
        adapter2.use18V();
    }
}
class Adapter2 {
    private Current current;

    public Adapter2(Current current) {
        this.current = current;
    }

    public void use18V() {
        System.out.println("使用适配器");
        this.current.use220V();
    }
}


package MainPack.util;

import org.hibernate.SessionFactory;

public class SingletonSessionHolder {

    private static volatile SingletonSessionHolder holder;

    public static SingletonSessionHolder getSingleton() {
        SingletonSessionHolder varHolder = holder;
        if (holder == null) {
            synchronized (SingletonSessionHolder.class) {
                varHolder = holder;
                if (varHolder == null) {
                    holder = varHolder = new SingletonSessionHolder();
                }
            }
        }
        return varHolder;
    }

    private SingletonSessionHolder() {
    }

    public SessionFactory getSessionFactory() {
        return HibernateSessionFactoryUtil.getSessionFactory();
    }
}

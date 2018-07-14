package practicaltask.riseapps.com.practicaltask.ui.base;

@FunctionalInterface
public interface Callback<T> {
    void call(T t);
}

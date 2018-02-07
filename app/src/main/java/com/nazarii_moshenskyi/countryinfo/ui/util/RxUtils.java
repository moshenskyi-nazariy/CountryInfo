package com.nazarii_moshenskyi.countryinfo.ui.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {
    public static <T> ObservableTransformer<T, T> applyProgressOnservable(Consumer<? super Disposable> onSubscribe, Action onFinally) {
        return upstream -> upstream.doOnSubscribe(onSubscribe).doFinally(onFinally);
    }

    public static <T> ObservableTransformer<T, T> applySchedulersObservable() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}

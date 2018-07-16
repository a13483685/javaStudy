package RxJava2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxJavaTest {
    private static Object TAG = "demo";

    public static void main(String str[]){
        //����һ������ Observable��
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });



        //����һ������ Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
//                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("onNext");
//                Log.d(TAG, "" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
//                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
//                Log.d(TAG, "complete");
            }
        };
        //��������
        observable.subscribe(observer);
    }
}

package com.project.service.Impl;

import com.project.service.RxJavaTestService;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RxJavaTestServiceImpl implements RxJavaTestService {

    private static final Logger logger = LogManager.getLogger(RxJavaTestServiceImpl.class);

    @Override
    public Observable<Integer> addThreeNumber(List<Integer> numberList) {
        logger.info("It's do something ..." );
        return Observable.create(e -> calculate(e, numberList));
    }

    private void calculate(ObservableEmitter<Integer> emitter, List<Integer> numberList) {
        logger.info("Calculate private method is called and it's ready ...");

        int count = 0;

        while(count < 5){
            numberList.stream()
                    .mapToInt(e -> e+1)
                    .forEach(emitter::onNext);
            sleep();
            count++;
        }

        emitter.onComplete();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

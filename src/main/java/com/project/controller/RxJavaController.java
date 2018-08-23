package com.project.controller;

import com.project.service.Impl.RxJavaTestServiceImpl;
import com.project.service.RxJavaTestService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rxjava")
public class RxJavaController {

    private static final Logger logger = LogManager.getLogger(RxJavaController.class);

    @Autowired
    private RxJavaTestService rxJavaTestService;

    @GetMapping
    public String doSm(){
        logger.info("rxJava endPoint is called");
        List<Integer> dsa = Arrays.asList(3,2,2);
        Observable<Integer> feed = rxJavaTestService.addThreeNumber(dsa);
        logger.info("addThreeNumber is finished...");
        feed.subscribe(
                System.out::println
        );
        return "final";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/single")
    public Single<String> single() {
        return Single.just("single value");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/singleWithResponse")
    public ResponseEntity<Single<String>> singleWithResponse() {
        return new ResponseEntity<>(Single.just("single value"),
                HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/singleCreatedWithResponse")
    public Single<ResponseEntity<String>> singleOuterWithResponse() {
        return Single.just(new ResponseEntity<>("single value", HttpStatus.CREATED));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/throw")
    public Single<Object> error() {
        return Single.error(new RuntimeException("Unexpected"));
    }
}

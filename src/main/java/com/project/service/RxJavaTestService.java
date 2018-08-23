package com.project.service;

import io.reactivex.Observable;

import java.util.List;

public interface RxJavaTestService {
    Observable<Integer> addThreeNumber(List<Integer> numberList);
}

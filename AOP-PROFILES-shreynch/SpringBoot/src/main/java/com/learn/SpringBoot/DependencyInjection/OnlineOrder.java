package com.learn.SpringBoot.DependencyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // helps to use this as a priority - way 1

@Qualifier("online") // way 2
public class OnlineOrder implements Order{

}

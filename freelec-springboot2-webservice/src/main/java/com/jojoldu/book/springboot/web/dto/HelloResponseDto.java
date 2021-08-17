package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//final 필드가 포함된 생성자를 생성함! final: 변경, 수정 절대 금지. 
@RequiredArgsConstructor
public class HelloResponseDto {
    
    
    private final String name;
    private final int amount;
}

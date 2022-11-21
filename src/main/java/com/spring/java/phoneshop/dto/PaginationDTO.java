package com.spring.java.phoneshop.dto;


import lombok.Data;

@Data
public class PaginationDTO {
    private int numberOfElements;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean empty;
    private boolean first;
    private boolean last;
}

package com.zimug.boot.lanuch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Value
public class Reader {

    private String name;

    private Integer age;
}

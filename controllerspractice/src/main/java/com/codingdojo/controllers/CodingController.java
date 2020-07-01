package com.codingdojo.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/coding")
public class CodingController {
        @RequestMapping("")
        public String hello() {
                return "Hola coding dojo!";
        }
        @RequestMapping("/python")
        public String helloPython() {
                return "¡Python/Django fue increíble!";
        }
        @RequestMapping("/java")
        public String hellPJava() {
                return "¡Java/Spring es mejor!";
        }
}
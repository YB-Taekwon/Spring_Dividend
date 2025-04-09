package com.ian.dividend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    // 검색 자동 완성 API
    @GetMapping("/autocomplete")
    public ResponseEntity<?> autocomplete(@RequestParam String keyword) {
        return null;
    }


    // 관심 회사 조회 API
    @GetMapping
    public ResponseEntity<?> searchCompany() {
        return null;
    }


    // 관심 회사 추가 API
    @PostMapping
    public ResponseEntity<?> addCompany() {
        return null;
    }


    // 관심 회사 삭제 API
    @DeleteMapping
    public ResponseEntity<?> deleteCompany() {
        return null;
    }
}

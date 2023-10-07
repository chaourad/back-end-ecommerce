package com.security.Electroplanet.demo;

import com.security.Electroplanet.entites.Categorie;
import com.security.Electroplanet.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
@Autowired
private CategorieService categorieService;
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin:read')")
    public List<Categorie> getCategory() {
        return categorieService.findAll();
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")

    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")

    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")

    public String delete() {
        return "DELETE:: admin controller";
    }


}

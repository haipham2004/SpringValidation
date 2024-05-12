package com.example.SpringValidation.controller;

import com.example.SpringValidation.request.SinhVienRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SinhVienController {

    @Value("${listKyHoc}")
    public List<String> kyHoc;

    @Value("${listSoThich}")
    public List<String> soThich;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("hienThiForm")
    public String hienThiForm(Model model) {
        model.addAttribute("sinhVienRequest", new SinhVienRequest());
        model.addAttribute("listKyHoc", kyHoc);
        model.addAttribute("listSoThich", soThich);
        return "SinhVien";
    }

    @PostMapping("xuLy")
    //đọc dữ liệu từ biểu mẫu HTML
    public String xuLy(@Valid @ModelAttribute("sinhVienRequest") SinhVienRequest sinhVienRequest,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listKyHoc", kyHoc);
            model.addAttribute("listSoThich", soThich);
            return "SinhVien";
        }
        return "ThongTinSinhVien";

    }
}

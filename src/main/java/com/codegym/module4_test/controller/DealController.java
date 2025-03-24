package com.codegym.module4_test.controller;

import com.codegym.module4_test.entity.Customer;
import com.codegym.module4_test.entity.Deal;
import com.codegym.module4_test.service.ICustomerService;
import com.codegym.module4_test.service.IDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private IDealService dealService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String index(
            Model model,
            @RequestParam Map<String, String> search
    ) {
        List<Deal> deals = dealService.getDeals(search);
        model.addAttribute("deals", deals);
        model.addAttribute("search", search);

        return "deal/list";
    }

    @GetMapping("/create")
    public String create(
            Model model
    ) {
        Deal deal = new Deal();
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        model.addAttribute("deal", deal);

        return "deal/form";
    }

    @PostMapping("/create")
    public String save(
            @Validated @ModelAttribute("deal") Deal deal,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("deal", deal);
            List<Customer> customers = customerService.getAll();
            model.addAttribute("customers", customers);

            return "deal/form";
        }
        dealService.save(deal);
        redirectAttributes.addFlashAttribute("message", "Thêm mới giao dịch thành công");
        return "redirect:/deal";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable long id,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        Deal deal = dealService.findById(id);
        if(deal == null) {
            redirectAttributes.addFlashAttribute("messageError", "Giao dịch không tồn tại");
            return "redirect:/deal";
        }
        model.addAttribute("deal", deal);

        return "deal/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable long id,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        Deal deal = dealService.findById(id);
        if(deal == null) {
            redirectAttributes.addFlashAttribute("messageError", "Giao dịch không tồn tại");
            return "redirect:/deal";
        }
        dealService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa giao dịch thành công");

        return "redirect:/deal";
    }
}

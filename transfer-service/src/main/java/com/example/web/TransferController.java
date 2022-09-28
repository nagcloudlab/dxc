package com.example.web;

import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import com.example.web.dto.TransferRequest;
import com.example.web.dto.TransferResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    private TransferService transferService;
    private Random random = new Random();

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public String showTransferForm() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println(principal);
        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
        grantedAuthorities.forEach(System.out::println);
        return "transfer-form";
    }

    @PostMapping
    public String doTransfer(
            @ModelAttribute @Valid TransferRequest transferRequest,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "redirect:error.html";
        }
        transferService.transfer(transferRequest.getAmount(), transferRequest.getSource(), transferRequest.getDestination());
        TransferResponse transferResponse = new TransferResponse(); // Model
        transferResponse.setTxnId(random.nextLong());
        transferResponse.setMessage("success");
        model.addAttribute("txr-response", transferResponse);
        return "redirect:transfer-status.html";
    }

//    @ExceptionHandler({
//            AccountNotFoundException.class,
//    })
//    public String handleException(Throwable t){
//        return "redirect:error.html";
//    }

}

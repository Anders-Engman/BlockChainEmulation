package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class App {

	@RequestMapping({ "/" })
	public String loadUI() {
		//log.info("loading UIssdd");
		return "forward:/index.html";
	}

}

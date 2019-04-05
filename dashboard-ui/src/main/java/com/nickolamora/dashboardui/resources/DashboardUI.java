package com.nickolamora.dashboardui.resources;

import com.nickolamora.dashboardui.models.DashboardItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

//Tells Spring that this is a controller that handles API mappings to methods
@RestController
//Map this API to this controller
@RequestMapping("/dashboard")
public class DashboardUI {

    @RequestMapping("/{userId}")
    public List<DashboardItem> getDashboard(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new DashboardItem("Chipotle", "TexMex restaurant", 5)
        );
    }
}

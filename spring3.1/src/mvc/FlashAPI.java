package mvc;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Map;

/**
 * @author Keesun Baik
 */
public class FlashAPI {

    @Test
    public void makeFlashMap(){
        FlashMap fm = new FlashMap();
        fm.put("message", "hi");
        fm.setTargetRequestPath("/user/list");
        fm.startExpirationPeriod(10); //초단위
    }

    @Test
    public void makeFlashMapWithUtil(){
        MockHttpServletRequest req = new MockHttpServletRequest();
        FlashMap fm = RequestContextUtils.getOutputFlashMap(req);
        fm.put("message", "hi");
    }

    @Test
    public  void takeOutFromFlashMap(){
        MockHttpServletRequest req = new MockHttpServletRequest();
        Map<String, ?> fm = RequestContextUtils.getInputFlashMap(req);
        String flashMessage = (String) fm.get("message");
        Model model = new ExtendedModelMap();
        model.addAttribute("flashMessage", flashMessage);
    }

}

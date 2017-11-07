import controller.VideoController;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class VideoControllerTest {
    @Test
    public void testGetMostViewed() {
        VideoController videoController = new VideoController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/mostViewed");
        request.setAttribute("id", 1);

        MockHttpServletResponse response = new MockHttpServletResponse();
        videoController.getMostViewed(request, response);
        assertEquals(200, response.getStatus());
        assertEquals(100L, (int) request.getAttribute("viewed"));
    }

    @Test
    public void testGetMostViewedWithNoId() {
        VideoController videoController = new VideoController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/mostViewed");

        MockHttpServletResponse response = new MockHttpServletResponse();
        videoController.getMostViewed(request, response);
        assertEquals(500, response.getStatus());
        assertNull(request.getAttribute("viewed"));
    }
}

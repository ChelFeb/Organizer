package ua.dp.skillsup.practice.organizer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import ua.dp.skillsup.practice.organizer.dto.EventDTO;
import ua.dp.skillsup.practice.organizer.service.EventService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {

    @InjectMocks
    private EventController createEventController;

    @Mock
    private ModelMap modelMap;

    @Mock
    private EventDTO eventDTO;

    @Mock
    BindingResult bindingResult;

    @Mock
    EventService eventService;

    @Test
    public void testShowEventPage() {
        assertEquals("events", createEventController.showEventsPage(modelMap));
    }

    @Test
    public void testAddNewEvent() {
        when(bindingResult.hasErrors()).thenReturn(false);
        assertEquals("redirect:/main", createEventController.addNewEvent(eventDTO, bindingResult, modelMap));
        when(bindingResult.hasErrors()).thenReturn(true);
        assertEquals("events", createEventController.addNewEvent(eventDTO, bindingResult, modelMap));
    }
}

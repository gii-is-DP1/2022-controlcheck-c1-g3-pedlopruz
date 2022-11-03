package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	private  RecoveryRoomService recoveryRoomService;
	private final String EDIT_RECOVERY_ROOM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private final String RECOVERY_ROOM_LISTING = "recoveryroom/recoveryRoomList";

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
	@GetMapping(value = "/")
	public ModelAndView showAllRecoveryRoom() {
		ModelAndView result = new ModelAndView(RECOVERY_ROOM_LISTING);
		result.addObject("product", recoveryRoomService.getAll());
		return result;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createRoom() {
		ModelAndView result = new ModelAndView(EDIT_RECOVERY_ROOM);
		RecoveryRoom room = new RecoveryRoom();
		result.addObject("recoveryRoom", room);
		return result;
		
	}
	@PostMapping(value = "/create")
	public ModelAndView showRoomById(@Valid RecoveryRoom room, BindingResult br) throws DuplicatedRoomNameException {
		ModelAndView result = null;
		if(br.hasErrors()) {
			result = new ModelAndView(EDIT_RECOVERY_ROOM);
			result.addAllObjects(br.getModel());
		}else {
			recoveryRoomService.save(room);
			result= new ModelAndView("welcome");
		}
		return result;
	}
	
    
}

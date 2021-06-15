package com.my.university.controller;

import com.my.university.dto.InstructorDTO;
import com.my.university.dto.Message;
import com.my.university.entity.Instructor;
import com.my.university.execption.UniversityException;
import com.my.university.response.InstructorResponse;
import com.my.university.service.InstructorService;
import com.my.university.utill.Constants;
import com.my.university.utill.ResponseConverter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/instructor",produces = "application/json")
public class InstructorController {
    @Autowired
    InstructorService instructorService;
    @Autowired
    ResponseConverter responseConverter;

    @ApiOperation(value = "", notes = "This API is used to create instructor detail",response = Message.class)
    @PostMapping("/register")
    public ResponseEntity<Object> addInstructor(@RequestBody InstructorDTO instructorDTO) {
        try {
            Integer id = instructorService.addInstructor(instructorDTO);
            String message = Constants.instructorRegSuccessMessage + id;
            return responseConverter.getSuccessResponse(message);

        }catch (UniversityException e){
            return responseConverter.getBadRequestMessage(e.getMessage());
        }
        catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
    @ApiOperation(value = "", notes = "This API is used update existing instructor detail",response = Message.class)
    @PutMapping("/change-details")
    public ResponseEntity<Object> updateDetails(@RequestBody InstructorDTO instructorDTO) {
        try {
            if(ObjectUtils.isEmpty(instructorDTO.getId())){
                throw new UniversityException(Constants.instructorIdRequired);
            }
            instructorService.updateInstructor(instructorDTO);
            return responseConverter.getSuccessResponse(Constants.instructorUpdateSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
    @ApiOperation(value = "", notes = "This API is used to delete existing instructor",response = Message.class)
    @DeleteMapping("/de-register/{instructorId}")
    public ResponseEntity<Object> deleteDetails(@PathVariable Integer instructorId) {
        try {
            instructorService.deleteInstructor(instructorId);

            return responseConverter.getSuccessResponse(Constants.instructorDeleteSuccessMessage);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
    @ApiOperation(value = "", notes = "This API is used to fetch instructor detail",response = InstructorResponse.class)
    @GetMapping("/details/{instructorId}")
    public ResponseEntity<Object> getInstructorDetail(@PathVariable Integer instructorId) {
        try {
            Instructor instructor = instructorService.getInstructor(instructorId);
            InstructorResponse instructorResponse = new InstructorResponse();
            BeanUtils.copyProperties(instructor, instructorResponse);

            return responseConverter.getSuccessResponse(instructorResponse);

        } catch (UniversityException e) {
            return responseConverter.getBadRequestMessage(e.getMessage());
        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
    @ApiOperation(value = "", notes = "This API is used to fetch all instructor details",responseContainer = "List",response = InstructorResponse.class)
    @GetMapping("/details/all")
    public ResponseEntity<Object> getAllInstructorDetail() {
        try {
            List<Instructor> instructorList = instructorService.getAllInstructor();
            if (!instructorList.isEmpty()) {
                List<InstructorResponse> _instructorList = new ArrayList<>();
                for (Instructor instructor : instructorList) {
                    InstructorResponse instructorResponse = new InstructorResponse();
                    BeanUtils.copyProperties(instructor, instructorResponse);
                    _instructorList.add(instructorResponse);
                }
                return responseConverter.getSuccessResponse(_instructorList);
            } else {
                return responseConverter.getBadRequestMessage(Constants.notFoundErrorMessage);
            }

        } catch (Exception e) {
            return responseConverter.getInternalServerError(Constants.genericErrorMessage);
        }
    }
}

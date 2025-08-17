package com.fkhrayef.schoolmanagementsystem.Service;

import com.fkhrayef.schoolmanagementsystem.Api.ApiException;
import com.fkhrayef.schoolmanagementsystem.DTO.AddressDTO;
import com.fkhrayef.schoolmanagementsystem.Model.Address;
import com.fkhrayef.schoolmanagementsystem.Model.Teacher;
import com.fkhrayef.schoolmanagementsystem.Repository.AddressRepository;
import com.fkhrayef.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacherId());
        if (address == null) {
            throw new ApiException("Address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Address not found");
        }

        Teacher teacher = address.getTeacher();
        if (teacher != null) {
            teacher.setAddress(null);
            teacherRepository.save(teacher);
        }
        addressRepository.delete(address);
    }
}

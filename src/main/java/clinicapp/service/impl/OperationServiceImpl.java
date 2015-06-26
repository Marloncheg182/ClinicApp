package clinicapp.service.impl;


import clinicapp.dbrepository.OperationRepository;
import clinicapp.entity.Operation;
import clinicapp.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;


    @Override
    public Operation addOperation(Operation operation) {
        Operation saveOperation = operationRepository.saveAndFlush(operation);
        return saveOperation;
    }

    @Override
    public Operation getById(long id) {
        return operationRepository.findById(id);
    }

    @Override
    public Operation getByDate(String date) {
        return operationRepository.findByDate(date);
    }

    @Override
    public List<Operation> getAll() {
        return operationRepository.findAll();
    }

    @Override
    public Operation editOperation(Operation operation) {
        return operationRepository.saveAndFlush(operation);
    }

    @Override
    public void delete(long id) {
        operationRepository.delete(id);
    }
}

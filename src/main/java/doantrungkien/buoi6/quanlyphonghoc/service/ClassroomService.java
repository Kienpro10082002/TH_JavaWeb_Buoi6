package doantrungkien.buoi6.quanlyphonghoc.service;

import doantrungkien.buoi6.quanlyphonghoc.model.Classroom;
import doantrungkien.buoi6.quanlyphonghoc.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Classroom not found with id: " + id));
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}


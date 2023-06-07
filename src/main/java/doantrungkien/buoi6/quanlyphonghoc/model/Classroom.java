package doantrungkien.buoi6.quanlyphonghoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "seating_capacity")
    private int seatingCapacity;

    @ManyToMany(mappedBy = "classrooms")
    private Set<Department> departments = new HashSet<>();

    // constructors, getters, setters
}


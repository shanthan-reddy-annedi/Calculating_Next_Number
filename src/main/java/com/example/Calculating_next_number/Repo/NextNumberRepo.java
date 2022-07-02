package com.example.Calculating_next_number.Repo;

import com.example.Calculating_next_number.Model.NextNumberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NextNumberRepo extends JpaRepository<NextNumberModel, Integer> {
}

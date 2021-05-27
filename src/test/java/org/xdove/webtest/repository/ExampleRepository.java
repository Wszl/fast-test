package org.xdove.webtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xdove.webtest.entity.Example;

public interface ExampleRepository extends JpaRepository<Example, Long> {
}

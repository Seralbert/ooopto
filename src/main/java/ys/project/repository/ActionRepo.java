package ys.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ys.project.model.etalon.Action;

/**
 * Created by Yuriy Smirnov on 30.01.2020.
 * Учет действий пользователя
 */
public interface ActionRepo extends JpaRepository<Action,Long> {
}

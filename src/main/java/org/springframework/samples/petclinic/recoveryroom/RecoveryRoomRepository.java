package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    public List<RecoveryRoom> findAll();
    public Optional<RecoveryRoom> findById(int id);
   
    @Query("SELECT recoverytype FROM RecoveryRoomType recoverytype")
    public List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    @Query("SELECT recoverytype FROM RecoveryRoomType recoverytype WHERE recoverytype.name = :name")
    public RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
}

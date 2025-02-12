package in.sp.main.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.sp.main.entity.SaleCourse;

public interface SaleCourseRepository extends JpaRepository<SaleCourse, Integer>
{
	@Query("SELECT date, COUNT(id) FROM SaleCourse GROUP BY date")
	List<Object[]> countByPurchasedDate();
	
	
	
	@Query("SELECT sc.date, COUNT(sc.id) FROM SaleCourse sc WHERE sc.date >= :date AND sc.coursename = :coursename GROUP BY sc.date" )
	List<Object[]> findBy(@Param("date") String date, @Param("coursename") String coursename);
	

	/*
	 * @Query("SELECT sc.date, COUNT(sc.id) FROM SaleCourse sc WHERE sc.date >= :date AND sc.coursename = :coursename GROUP BY sc.date"
	 * ) List<Object[]> findBy(String date, String coursename);
	 */
	
	
}

/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.isoft.reg.repository;

import io.isoft.reg.domain.City;
import io.isoft.reg.domain.Hotel;
import io.isoft.reg.domain.HotelSummary;
import io.isoft.reg.domain.RatingCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface HotelRepository extends Repository<Hotel, Long> {

	Hotel findByCityAndName(City city, String name);

	@Query("select new io.isoft.reg.domain.HotelSummary(h.city, h.name, avg(r.rating)) from io.isoft.reg.domain.Hotel h left outer join h.reviews r where h.city = ?1 group by h")
	Page<HotelSummary> findByCity(City city, Pageable pageable);

	@Query("select new io.isoft.reg.domain.RatingCount(r.rating, count(r)) "
			+ "from Review r where r.hotel = ?1 group by r.rating order by r.rating DESC")
	List<RatingCount> findRatingCounts(Hotel hotel);
}

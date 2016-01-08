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

package io.isoft.reg.service;

import io.isoft.reg.domain.City;
import io.isoft.reg.domain.HotelSummary;
import io.isoft.reg.repository.criteria.CitySearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CityService {

	Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);
//	Page<CvBloodTypeDict> findBloodList(CitySearchCriteria criteria, Pageable pageable);
	City getCity(String name, String country);

	Page<HotelSummary> getHotels(City city, Pageable pageable);

}

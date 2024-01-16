import React, { useEffect, useState } from 'react';
import Slider from 'react-slick';
import { CarModel } from '../../models/carModels/GetAllCarModel';
import CarService from '../../service/carService/CarService';
import './SliderComp.css';

type Props = {};

const SliderComp = (props: Props) => {
	const [cars, setCars] = useState<CarModel[]>([]);
	const [randomCarIndexes, setRandomCarIndexes] = useState<number[]>([]);

	useEffect(() => {
		fetchCars();
	}, []);

	const fetchCars = async () => {
		try {
			CarService.getAll().then((response) => {
				setCars(response.data);

				const indexes = Array.from({ length: Math.min(response.data.length, 4) }, () =>
					Math.floor(Math.random() * response.data.length)
				);
				setRandomCarIndexes(indexes);
			})
			} catch (error) {
				console.error('Error fetching cars:', error);
			}
		};

		const settings = {
			dots: true,
			infinite: true,
			speed: 500,
			slidesToShow: 1,
			slidesToScroll: 1,
			autoplay: true,
			autoplaySpeed: 1500,
		};

		return (
			<div className="slider-comp-container mt-5">
				<Slider {...settings} className="custom-slider">
					{randomCarIndexes.map((index, idx) => (
						<div key={idx} className="slider-item">
							{cars[index] && (
								<>
									<div className="row">
										<div className="col-md-6">
											<div className="car-info">
												<h2>{cars[index].model.brand.name} {cars[index].model.name} </h2>
												<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nisi, delectus?</p>

											</div>
										</div>
										<div className="col-md-6">
											<img
												src={cars[index].imagePath}
												alt={`Car Image - ${cars[index].imagePath}`}
											/>
										</div>
									</div>
								</>
							)}
						</div>
					))}
				</Slider>
			</div>
		);
	};

	export default SliderComp;

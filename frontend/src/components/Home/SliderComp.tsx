import React, { useEffect, useState } from 'react';
import Slider from 'react-slick';
import { CarModel } from '../../models/carModels/GetAllCarModel';
import CarService from '../../service/carService/CarService';
import './SliderComp.css';

type Props = {};

type ArrowProps = {
  className?: string;
  style?: React.CSSProperties;
  onClick?: () => void;
};

// Custom arrow component for image
const ImageArrow = (props: ArrowProps) => {
  const { className, onClick } = props;
  return (
    <div
      className={`${className} arrow image-arrow`}
      onClick={onClick}
    />
  );
};

// Custom arrow component for title and paragraph
const TextArrow = (props: ArrowProps) => {
  const { className, onClick } = props;
  return (
    <div
      className={`${className} arrow text-arrow`}
      onClick={onClick}
    />
  );
};

const SliderComp = (props: Props) => {
  const [cars, setCars] = useState<CarModel[]>([]);
  const [randomCarIndexes, setRandomCarIndexes] = useState<number[]>([]);
  const [currentSlide, setCurrentSlide] = useState<number>(0); // Eklenen satır

  useEffect(() => {
    fetchCars();
  }, []);

  const fetchCars = async () => {
    try {
      const response = await CarService.getAll();
      setCars(response.data);

      const indexes = Array.from({ length: Math.min(response.data.length, 4) }, () =>
        Math.floor(Math.random() * response.data.length)
      );
      setRandomCarIndexes(indexes);
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
    nextArrow: <ImageArrow />,
    prevArrow: <TextArrow />,
    beforeChange: (current: number, next: number) => setCurrentSlide(next), // Eklenen satır
  };

  return (
    <div className="slider-comp-container">
      <Slider {...settings} className="custom-slider">
        {randomCarIndexes.map((index, idx) => (
          <div key={idx} className={`slider-item ${currentSlide === idx ? 'active' : ''}`}>
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

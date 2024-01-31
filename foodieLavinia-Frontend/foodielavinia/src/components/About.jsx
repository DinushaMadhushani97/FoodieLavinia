import React from 'react';
import ResturantMP4 from '../videoes/Resturant.mp4';

const About = () => {
  return (
    <div>
      <h1 style={{ margin: '50px', padding: '0px', color: 'white' }}>
          <center>About Us</center>
        </h1>
      <div className="video-description-container">
        <div className="video-container">
          <video width={640} height={360} controls autoPlay loop muted disableRemotePlayback>
            <source src={ResturantMP4} type='video/mp4' />
          </video>
        </div>
        <div className="description-container">
          <p>
            Welcome to our restaurant! We are passionate about serving delicious food in a cozy and welcoming atmosphere. Our team of talented chefs creates mouthwatering dishes using the freshest ingredients.
          </p>
          <p>
            Whether you're dining in with friends and family or ordering takeout, we strive to provide an exceptional culinary experience that will leave you craving for more. Join us for an unforgettable dining adventure!
          </p>
        </div>
      </div>
    </div>
  );
}

export default About;

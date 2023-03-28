import React, { useState, useEffect } from "react";
import { Container } from "reactstrap";
import AppNav from "./AppNav";
import image from "./images/default.png";
import AppNavHor from "./components/AppNavHor";

const About = () => {
  const [windowDim, setWindowDim] = useState({
    winWidth: window.innerWidth,
    winHeight: window.innerHeight,
  });

  const [width, setWidth] = useState("83%");

  //handle window resize
  const detectSize = () => {
    setWindowDim({
      winWidth: window.innerWidth,
      winHeight: window.innerHeight,
    });
    {
      window.innerWidth < 600 && setWidth("100%");
    }
  };
  useEffect(() => {
    window.addEventListener("resize", detectSize);
    return () => {
      window.removeEventListener("resize", detectSize);
    };
  }, [windowDim]);

  return (
    <>
      {windowDim.winWidth < 600 && <AppNavHor />}

      <div
        className="d-flex"
        style={{ backgroundColor: "#EEF5F7", height: "100%" }}
      >
        {windowDim.winWidth > 600 && <AppNav sticky="top" />}
        <div style={{ backgroundColor: "white", width: { width } }}>
          <Container className="mb-4">
            <img src={image} alt="Logo" style={{ width: "80%" }} />
            <h1>Welcome!</h1>
            <p>
              The Project Budget Tracker app assists independent developers
              track expenses and maintain a budget during product development.
              It offers a quick view of the current expenses and sort options to
              separate individual expense category items. Personalized
              categories can be added, or deleted. The application maintains
              security on both the front and back end, and supports security and
              monitoring individual user expenses.
            </p>
            <h2>Features</h2>
            <p>Basic features include -</p>
            <ul>Landing Page</ul>
            <ul>Login and Registration</ul>
            <ul>Income/Expense Category Manage</ul>
            <ul>Income/Expense Transaction Manage</ul>
            <ul>Category Wise Income Expense Chart</ul>
            <ul>Responsive UI</ul>
            <ul>Manage Transections</ul>
            <ul>Record activity</ul>
            <ul>Summary Charts</ul>

            <h2>Tech Stacks</h2>
            <ul>Frontend: React JS</ul>
            <ul>Backend: Spring Boot</ul>
            <ul>Database: H2</ul>

            <h2>More Info</h2>
            <p>
              This application was a portfolio project by Keawe Aquarian. It was
              primarily a project to learn react and create a complete full
              stack application from database creation through frontend, hosting
              and security.
            </p>
            <h2>Challenges that were overcome:</h2>
            <ul>Cors, Cors, Cors!</ul>
            <ul>React State logic—where did my update go?</ul>
            <ul>Spring security and jwt token control</ul>
            <ul>Http vs https </ul>
            <h2>Contact</h2>
            <a href="mailto: keaweaquarian@gmail.com">
              keaweaquarian@gmail.com
            </a>
            <br />
            <a href="https://keaweaquarian.com/">Keawe's Portfolio</a>
            <br />
          </Container>
        </div>
      </div>
    </>
  );
};

export default About;

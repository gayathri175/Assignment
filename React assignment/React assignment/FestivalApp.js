// import React, useState for state, useEffect for lifecycle
import React, { useState, useEffect } from "react";
//useeffect is maily used to run side effects of our component side effcts noothing but settimer showing alerts
const FestivalApp = () => {
  // Festival state (starts with Diwali)
  const [festival, setFestival] = useState("Diwali");

  // countdown state (starts with 5 seconds)
  const [countdown, setCountdown] = useState(5);

  // state to store timer id (so we can stop it later)
  const [timerId, setTimerId] = useState(null);

  // from qstn1 Print message on every render (no dependency array)
  useEffect(() => {
    console.log("Festival App Rendered");
  });

  // from qstn2 Run once → Welcome message (empty dependency array [])
  useEffect(() => {
    console.log("Welcome to Diwali Festival App");
    alert("Welcome to Diwali Festival App");
  }, []);

  // from qstn3 Festival change tracker (runs whenever festival changes)
  useEffect(() => {
    console.log(`Festival changed to ${festival}. Seconds left: ${countdown}`);
  }, [festival]);

  // from qstn 4 Countdown timer (cleanup example)
  useEffect(() => {
    // Start a timer that decreases countdown every second
    const id = setInterval(() => {
      setCountdown((prev) => prev - 1);
    }, 1000);

    setTimerId(id); // Save the timer id in state

    // Cleanup → clear timer when component unmounts
    return () => {
      clearInterval(id);
    };
  }, []);

  // from qstn 5 Multiple dependencies (festival OR countdown changes)
  useEffect(() => {
    console.log(`Festival: ${festival}, Countdown: ${countdown}`);
  }, [festival, countdown]);

  // Function to stop timer manually
  const stopTimer = () => {
    clearInterval(timerId); // stop the interval
    console.log("Timer stopped by user!");
  };

  return (
    <div style={{ padding: "20px" }}>
      {/* Title */}
      <h1>Festival React App</h1>

      {/* Show current festival */}
      <h2>Current Festival: {festival}</h2>

      {/* Show countdown timer */}
      <h3>Countdown: {countdown}</h3>

      {/* Buttons to change festival */}
      <button onClick={() => setFestival("Holi")}>Change to Holi</button>
      <button onClick={() => setFestival("Pongal")}>Change to Pongal</button>

      {/* Button to stop timer */}
      <button onClick={stopTimer} style={{ marginLeft: "10px" }}>
        Stop Countdown
      </button>
    </div>
  );
};

// Export FestivalApp so App.js can use it
export default FestivalApp;

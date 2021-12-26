import React from "react";
import { render, screen } from "@testing-library/react";
import LandingPage from "./LandingPage";

describe("Landing Page", () => {
  test("renders properly", () => {
    render(<LandingPage />);
    //screen.debug();
  });
  test("contains proper text", () => {
    const { getByText } = render(<LandingPage />);
    expect(getByText("Testimonials")).toBeInTheDocument();
  });
  test("should contains button Log In", () => {
  });
});

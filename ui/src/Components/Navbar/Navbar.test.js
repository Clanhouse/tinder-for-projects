import React from "react";
import { render } from "@testing-library/react";
import Navbar from "./Navbar";

describe("Navbar", () => {
  test("renders properly ", () => {
    render(<Navbar />);
  });
  test("contains Logo image ", () => {
    const { getByAltText } = render(<Navbar />);
    expect(getByAltText("Apps logo")).toBeInTheDocument();
  });
  test("contains unordered list ", () => {
    const { getByTestId } = render(<Navbar />);
    expect(getByTestId("ul-navbar")).toBeInTheDocument();
  });
  test("contains list items", () => {
    const { getByText } = render(<Navbar />);
    expect(getByText("Products")).toBeInTheDocument();
  });
  test("contains list items", () => {
    const { getByText } = render(<Navbar />);
    expect(getByText("Learn")).toBeInTheDocument();
  });
});

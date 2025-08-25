import React from "react";

// importing hook and components from Components.js
import {
  useProductData,
  LoadingComponent,
  ErrorComponent,
  ProductComponent,
} from "./Components";

const ConditionalApp = () => {
  // get loading, error, product states from our custom hook
  const { loading, error, product } = useProductData();

  return (
    <div style={{ padding: "20px" }}>
      {/* Page title */}
      <h2>Lab Question: Conditional Rendering with Multiple Components</h2>

      {/* If still loading → show LoadingComponent */}
      {/* If error happened → show ErrorComponent */}
      {/* Otherwise → show ProductComponent */}
      {loading ? (
        <LoadingComponent />
      ) : error ? (
        <ErrorComponent />
      ) : (
        <ProductComponent product={product} />
      )}
    </div>
  );
};

export default ConditionalApp;
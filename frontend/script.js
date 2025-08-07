const backendURL = "http://localhost:8080/api"; // Update if your backend is hosted elsewhere

async function encode() {
  const image = document.getElementById("encodeImage").files[0];
  const message = document.getElementById("encodeMessage").value;
  const passcode = document.getElementById("encodePasscode").value;

  if (!image || !message || !passcode) {
    document.getElementById("encodeStatus").innerText = "❗ Fill all fields!";
    return;
  }

  const formData = new FormData();
  formData.append("image", image);
  formData.append("message", message);
  formData.append("passcode", passcode);

  try {
    const res = await fetch(`${backendURL}/encode`, {
      method: "POST",
      body: formData,
    });

    if (!res.ok) {
      document.getElementById("encodeStatus").innerText = "❌ Error encoding message.";
      return;
    }

    const blob = await res.blob();
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement("a");
    a.href = url;
    a.download = "encoded_image.png";
    a.click();
    document.getElementById("encodeStatus").innerText = "✅ Encoded image downloaded.";
  } catch (err) {
    document.getElementById("encodeStatus").innerText = "❌ Server error.";
  }
}

async function decode() {
  const image = document.getElementById("decodeImage").files[0];
  const passcode = document.getElementById("decodePasscode").value;

  if (!image || !passcode) {
    document.getElementById("decodeResult").innerText = "❗ Upload image & enter passcode!";
    return;
  }

  const formData = new FormData();
  formData.append("image", image);
  formData.append("passcode", passcode);

  try {
    const res = await fetch(`${backendURL}/decode`, {
      method: "POST",
      body: formData,
    });

    const result = await res.text();
    document.getElementById("decodeResult").innerText = result;
  } catch (err) {
    document.getElementById("decodeResult").innerText = "❌ Server error.";
  }
}

export async function getAllBlocks() {
  let response;
  try {
    response = await fetch("/api/blocks");
  } catch (e) {
    console.log(e);
  }

  return await response.json();
}

// export async function createUser(data) {
//   const response = await fetch(`/api/user`, {
//     method: "POST",
//     headers: { "Content-Type": "application/json" },
//     body: JSON.stringify(data),
//   });
//   return await response.json();
// }

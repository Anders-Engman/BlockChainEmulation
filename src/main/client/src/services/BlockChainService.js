const ENDPOINTS = {
  loadBlock: "/api/load-blocks",
  createBlock: "/api/add-block",
  mineBlock: "/api/mine-block",
  updateBlock: "/api/chain-update",
};

export async function getAllBlocks() {
  let response;
  try {
    response = await fetch(ENDPOINTS.loadBlock)
      .then((r) => r.json().then((data) => ({ status: r.status, body: data })))
      .then((obj) => obj);
  } catch (e) {
    console.log(e);
  }

  return response;
}

export async function createBlock({ data, parentHash, id }) {
  const options = { data, parentHash, id, hash: "" };

  try {
    await fetch(ENDPOINTS.createBlock, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(options),
    });

    return true;
  } catch (e) {
    console.log(e);
    return false;
  }
}

export async function mineBlock({ id, data, hash, parentHash }) {
  const options = { id, data, hash, parentHash };

  const endpoint = `${ENDPOINTS.mineBlock}/${id}`;

  try {
    await fetch(endpoint, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(options),
    });

    return true;
  } catch (e) {
    console.log(e);
    return false;
  }
}

export async function updateBlock({ id, data, hash, parentHash }) {
  const options = { id, data, hash, parentHash };

  const endpoint = `${ENDPOINTS.updateBlock}/${id}`;

  try {
    await fetch(endpoint, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(options),
    });

    return true;
  } catch (e) {
    console.log(e);
    return false;
  }
}

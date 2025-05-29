# 🧩 Maze Solver in Java (DFS Algorithm)

This is a simple Java implementation of a **Depth-First Search (DFS)** algorithm to determine whether a maze is solvable from a given start point to an end point.

## 📌 Problem Statement

Given a 2D grid (maze) consisting of:
- `S` – Start point
- `E` – End point
- `.` – Passable path
- `#` – Wall (impassable)

Determine whether a path exists from `S` to `E`.

---

## 🚀 How It Works

The program uses a **stack-based DFS algorithm** to traverse the maze. At each step, it:
1. Checks the current cell.
2. Marks it as visited.
3. Adds its valid (non-wall, in-bounds) neighbors to the stack.
4. Repeats until it either finds the exit (`E`) or exhausts all possibilities.

---

## 🧠 Core Algorithm

- Uses a `Stack<int[]>` to implement DFS traversal.
- Tracks visited cells using a `HashSet<String>`.
- Valid moves are in four directions: up, down, left, and right.
- Rejects moves that go out of bounds or hit a wall (`#`).

---

## 📦 Code Structure

- `solveMaze(...)`: Main DFS logic to determine if the maze is solvable.
- `getNeighbors(...)`: Finds valid neighboring cells for DFS traversal.
- `isSolvableMethod(...)`: Returns "Yes!" or "No!" based on result.
- `main(...)`: Sample usage with a hardcoded maze.

---

## 🧪 Example Maze

```text
S . . # #
. # . . #
. # # . #
. . . # .
# # # . E
```

---

## ✅ Output

```
Is the maze solvable: Yes!
```

## 🛠️▶️ How to Run

```bash
java src/App.java
```

## 👨‍💻 Author
Zayniev Sanjar in December, 2023. 

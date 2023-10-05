def max_score(n, m, tunnels):
  """
  Returns the maximum score that can be obtained by walking from room 1 to room n,
  given a list of tunnels and their scores.

  Args:
    n: The number of rooms.
    m: The number of tunnels.
    tunnels: A list of tuples (a, b, x), where a and b are the start and end nodes
      of the tunnel, and x is the score of the tunnel.

  Returns:
    The maximum score that can be obtained, or -1 if the score can be arbitrarily
    large.
  """

  # Create a graph to represent the tunnels.
  graph = {}
  for tunnel in tunnels:
    a, b, x = tunnel
    if a not in graph:
      graph[a] = []
    graph[a].append((b, x))

  # Initialize the distance to each room from room 1 to be infinite.
  distance = {}
  for i in range(1, n + 1):
    distance[i] = float('inf')

  # Initialize the queue to contain only room 1.
  queue = [1]

  # Perform a breadth-first search to find the shortest path from room 1 to room n.
  while queue:
    node = queue.pop(0)
    if node == n:
      return distance[node]

    for neighbor, score in graph[node]:
      new_distance = distance[node] + score

      # If the new distance is shorter than the current distance and there is no
      # cycle, update the distance and add the neighbor to the queue.
      if new_distance < distance[neighbor] and not has_cycle(graph, node, neighbor):
        distance[neighbor] = new_distance
        queue.append(neighbor)

  # If we cannot reach room n, return -1.
  if distance[n] == float('inf'):
    return -1

  # Otherwise, return the distance to room n.
  return distance[n]


def has_cycle(graph, node, neighbor):
  """
  Returns True if there is a cycle in the graph starting at node and ending at
  neighbor, False otherwise.
  """

  visited = set()
  stack = [node]

  while stack:
    current_node = stack.pop()

    if current_node == neighbor:
      return True

    if current_node not in visited:
      visited.add(current_node)
      for next_neighbor, _ in graph[current_node]:
        if next_neighbor not in visited:
          stack.append(next_neighbor)

  return False


# Read the input.
n, m = map(int, input().split())
tunnels = []
for i in range(m):
  tunnels.append(tuple(map(int, input().split())))

# Compute the maximum score.
max_score = max_score(n, m, tunnels)

# Print the output.
print(max_score)
# Contributing Guidelines

Thank you for contributing to **OrderFlow**.

To maintain a clean and organized codebase, please follow the guidelines below.

# Branching Strategy
Do **not** commit directly to the `main` branch after the initial project setup.
Each contributor should create a dedicated feature branch.
Example:

```
feature/backend-setup
feature/ring-buffer
feature/event-producer
feature/frontend-ui
feature/devops
```

# Development Workflow

1. Pull the latest changes from `main`.

```bash
git checkout main
git pull origin main
```

2. Create a feature branch.

```bash
git checkout -b feature/your-feature
```

3. Make changes and commit frequently.

4. Push your branch.

```bash
git push origin feature/your-feature
```

5. Open a Pull Request.

6. Request at least one team member to review the code.

7. Merge only after approval.

# Commit Message Convention

Use meaningful commit messages.

Examples:

```
feat: implement order event producer

fix: resolve ring buffer initialization

docs: update architecture documentation

refactor: simplify order processing

test: add unit tests for matching engine

chore: configure logging
```



# Coding Standards

- Write clean and readable code.
- Keep methods focused on a single responsibility.
- Follow Java naming conventions.
- Document public methods where necessary.
- Remove unused imports before committing.

---

# Pull Request Checklist

Before creating a Pull Request, ensure that:

- Code builds successfully.
- No merge conflicts exist.
- Changes have been tested.
- Documentation is updated if required.
- Commit messages follow the project convention.

# Code Review

Every Pull Request should be reviewed before merging.

Reviewers should verify:

- Code quality
- Readability
- Correctness
- Documentation updates
- No unnecessary files are committed
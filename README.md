Markov Text Generator
**Overview**

This project implements a Markov chain–based text generator using Java. It models sequences of words from a training text and produces new, statistically realistic passages based on the learned patterns. The project highlights the use of immutable data structures, hashing for efficiency, and generative modeling techniques in natural language processing.

**Features**

WordGram Class

Designed an immutable data structure to represent fixed-length sequences of words.

Implemented equals, hashCode, and toString methods to enable hashing and comparison.

Base vs. HashMarkov Models

Implemented a baseline Markov model for generating text.

Optimized performance with a HashMap<WordGram, List<String>>, improving runtime by storing word sequences and their possible continuations.

Random Text Generation

Trained models on sample texts (e.g., Alice in Wonderland) to produce pseudo-natural outputs.

Verified correctness and reproducibility with seeded randomness.

Unit Testing

Used JUnit to validate functionality of WordGram and HashMarkov.

Ensured correctness through both functional and efficiency tests.

**Technologies & Skills**

Language: Java

Core Skills:

Generative modeling with Markov chains

Data structures: hashing with HashMap, immutability with custom classes

Algorithmic efficiency analysis (Big-O reasoning)

Unit testing with JUnit

**Concepts:**

Randomized algorithm design

Trade-offs between naive and optimized implementations

**What I Learned**

How generative models can be built from simple probabilistic principles.

The importance of hashing to drastically improve runtime efficiency.

How immutability in object design simplifies correctness and testing.

How algorithm design and analysis connect directly to practical performance.

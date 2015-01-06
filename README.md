OCR
===

Java implementation of Optical Character Recognition 


How It Works
------------
The core concept, at the character level, is image matching with automatic position and aspect ratio correction, using a least-square-error matching algorithm. 

Phases
------

### Training Phase
1. Printing out the characters which it is expected to recognize
2. Scanning those characters into an image
3. Cropping the image down so that it includes only the training characters
4. Telling the OCR engine to use the resulting training image, and specifying which characters the image contains

### Character Recognition
1. Load training images
2. Load the scanned image of the document to be converted to text
3. Convert the scanned image to grayscale
4. Filter the scanned image using a low-pass Finite Impulse Response (FIR) filter to remove dust
5. Break the document into lines of text, based on whitespace between the text lines
6. Break each line into characters, based on whitespace between the characters; using the average character width, determine where spaces occur within the line
7. For each character, determine the most closely matching character from the training images and append that to the output text; for each space, append a space character to the output text
8. Output the accumulated text
9. If there are any more scanned images to be converted to text, return to step 2